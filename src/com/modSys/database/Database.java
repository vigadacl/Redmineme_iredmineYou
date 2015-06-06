package com.modSys.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.modSys.logger.Log;
import com.modSys.model.Remidne;
import com.modSys.model.User;

public class Database extends SQLiteOpenHelper {

	private static final String TAG = "Database";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "ModSys";

	// Table Names
	private static final String TABLE_USER = "user";
	private static final String TABLE_REMIDNE = "remidne";

	// column user
	private static final String USERID = "userId";
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";

	// column remidne
	private static final String REMIDNEID = "remidneId";
	private static final String REMIDNENAME = "name";
	private static final String START = "start";
	private static final String END = "end";
	private static final String DELAY = "delay";
	private static final String USERS = "users";

	/**
	 * Default constructor for the database.
	 * 
	 * @param context
	 *            the application.
	 */
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_USER + " ( " + USERID + " INTEGER PRIMARY KEY, "
				+ EMAIL + " TEXT, " + NAME + " TEXT, " + PASSWORD + " TEXT "
				+ ")";

		final String CREATE_REDMINE_TABLE = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_REMIDNE + " ( " + REMIDNEID + " INTEGER PRIMARY KEY, "
				+ REMIDNENAME + " TEXT, " + START + " DATE " + END + " DATE "
				+ DELAY + " DATE " + USERS + " TEXT " + ")";

		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_REDMINE_TABLE);
		Log.i(TAG, "Tables have been created.");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop tables that already exist
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMIDNE);
		Log.i(TAG, "Tables have been dropped and will be recreated.");

		// Recreate tables
		this.onCreate(db);
	}

	// USER CRUD

	/**
	 * This method creates and stores a new user in the database. The data is
	 * taken from the {@link User} object that is passed to the method.
	 * 
	 * @param user
	 *            the {@link User} object from which the data will be taken.
	 */
	public void createOrUpdateUser(User user) {
		final SQLiteDatabase db = getWritableDatabase();

		final ContentValues values = new ContentValues();

		values.put(EMAIL, user.getEmail());
		values.put(NAME, user.getName());
		values.put(PASSWORD, user.getPassword());

		User user1 = getUserFromDb(user.getId());
		if (user1 == null) {
			final long rowID = db.insert(TABLE_USER, null, values);
			Log.i(TAG, "User " + rowID + " has been added.");
		} else {
			final long rowID = db.update(TABLE_USER, values, USERID + "=?",
					new String[] { String.valueOf(user.getId()) });
			Log.i(TAG, "User " + rowID + " has been updated.");
		}

	}

	public void deleteUserById(int id) {
		final SQLiteDatabase db = getWritableDatabase();

		db.delete(TABLE_USER, USERID + "='" + id + "'", null);
	}

	/**
	 * This method deletes all entries of the {@link User} table.
	 */
	public void deleteAllUser() {
		final SQLiteDatabase db = getWritableDatabase();
		db.delete(TABLE_USER, null, null);
	}
    
	/**
	 * check if a email was already store in database
	 * 
	 * @param email
	 * @return
	 */
	public boolean containEmail(String email) {
		final SQLiteDatabase db = getReadableDatabase();

		String query = "select * from " + TABLE_USER + " where " + EMAIL
				+ " ='" + email + "'" ;
		Cursor cursor = db.rawQuery(query, null);

		if (cursor.moveToFirst()) {
			cursor.close();
			return true;
		} 
		cursor.close();
		return false;
	}

	public Cursor getInformations(String email, String password) {
		final SQLiteDatabase db = getWritableDatabase();

		String[] columns = {USERID, EMAIL,NAME, PASSWORD };
		Cursor cursor = db.query(TABLE_USER, columns, null, null, null, null,
				null);

		return cursor;
	}

	/**
	 * 
	 * @param id
	 * @return a user based on his email address
	 */
	public User getUserFromDb(int id) {

		final SQLiteDatabase db = getReadableDatabase();
		String query = "SELECT " + USERID + " , " + EMAIL + ", " + NAME + ", "
				+ PASSWORD + " FROM " + TABLE_USER + " WHERE " + USERID + " = "
				+ id;

		final Cursor cursor = db.rawQuery(query, null);

		String name = "";
		String email = "";
		String password = "";

		if (cursor != null && cursor.moveToFirst()) {
			email = cursor.getString(1);
			name = cursor.getString(2);
			password = cursor.getString(3);

			User user = new User(email, name, password);
			cursor.close();
			return user;
		}
		cursor.close();
		return null;
	}

	/**
	 * This method returns a list of all users stored in the database and
	 * creates corresponding {@link User} objects.
	 * 
	 * @return a list of users.
	 */
	public synchronized List<User> getAllUserByName() {
		final List<User> users = new ArrayList<User>();

		final SQLiteDatabase db = getReadableDatabase();
		final Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);

		if (cursor != null) {
			while (cursor.moveToNext()) {
				final User user = new User(cursor.getString(2));
				users.add(user);
			}
		}
		Log.i(TAG, users.size() + " usernames were retrieved from the database.");
		return users;
	}

	// REMIDNE CRUD

	public String join(List<String> elements, String separator) {

		if (elements == null || elements.isEmpty()) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		for (Iterator<String> iterator = elements.iterator(); iterator
				.hasNext();) {
			String string = (String) iterator.next();
			builder.append(string.toString());
			if (iterator.hasNext()) {
				builder.append(separator);
			}
		}
		return builder.toString();
	}

	/**
	 * This method creates and stores a new user in the database. The data is
	 * taken from the {@link User} object that is passed to the method.
	 * 
	 * @param user
	 *            the {@link User} object from which the data will be taken.
	 */
	public void createRemidne(Remidne remidne) {
		final SQLiteDatabase db = getWritableDatabase();

		final ContentValues values = new ContentValues();

		String[] usern = new String[remidne.getUsers().size()];
		;

		for (int i = 0; i < usern.length; i++) {

			usern[i] = remidne.getUsers().get(i).getName();
		}

		String userlist = join(Arrays.asList(usern), ",");
		values.put(NAME, remidne.getName());
		values.put(START, remidne.getStart());
		values.put(END, remidne.getEnd());
		values.put(DELAY, remidne.getDelay());
		values.put(USERS, userlist);

		Remidne redmineFromDb = getRemidneFromDb(remidne);
		if (redmineFromDb == null) {

			db.insert(TABLE_REMIDNE, null, values);
		} else {

			db.update(TABLE_REMIDNE, values, REMIDNEID + "=?",
					new String[] { String.valueOf(redmineFromDb.getId()) });
		}

		final long rowID = db.insert(TABLE_REMIDNE, null, values);
		Log.i(TAG, "remidne " + rowID + " has been added.");
	}

	public Remidne getRemidneFromDb(Remidne remidne) {
		final SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT " + REMIDNEID + ", " + REMIDNENAME + " , "
				+ START + " , " + END + " , " + DELAY + " , " + USERS
				+ " FROM " + TABLE_REMIDNE + " WHERE " + REMIDNEID + " = "
				+ remidne.getId();

		final Cursor cursor = db.rawQuery(query, null);

		int remidneId = 0;
		String name = "";
		String start = "";
		String end = "";
		String delay = "";
		String users = "";

		if (cursor != null && cursor.moveToFirst()) {
			remidneId = cursor.getInt(0);
			name = cursor.getString(1);
			start = cursor.getString(2);
			end = cursor.getString(3);
			delay = cursor.getString(4);
			users = cursor.getString(5);

			remidne.setId(remidneId);
			remidne.setName(name);
			remidne.setStart(start);
			remidne.setEnd(end);
			remidne.setDelay(delay);
			cursor.close();
			return remidne;

		}

		cursor.close();

		return null;
	}

	public List<Remidne> getAllRemidne() {
		final List<Remidne> remidnes = new ArrayList<Remidne>();

		final SQLiteDatabase db = getReadableDatabase();
		final Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REMIDNE,
				null);

		if (cursor != null) {
			while (cursor.moveToNext()) {
				final Remidne remidne = new Remidne(cursor.getString(1),
						cursor.getString(2), cursor.getString(3),
						cursor.getString(4));
				remidnes.add(remidne);
			}
		}
		Log.i(TAG, remidnes.size() + " users were retrieved from the database.");
		return remidnes;
	}

}
