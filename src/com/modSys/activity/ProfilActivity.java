package com.modSys.activity;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.tes.modulSystem.R;


public class ProfilActivity extends Activity  implements OnClickListener{


	private final int SELECT_PHOTO = 1;
	private ImageView imageView;
	
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.profil);
	        //action bar set title and icon to this activity
	        setTitle(R.string.profil);
	        getActionBar().setIcon(R.drawable.imageprofil);
	        getActionBar().setHomeButtonEnabled(true);
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        getActionBar().setDisplayShowHomeEnabled(true);
	       
	        imageView = (ImageView)findViewById(R.id.img1);

	        //pick image from gallery
	        imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {				
					Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
					photoPickerIntent.setType("image/*");
					startActivityForResult(photoPickerIntent, SELECT_PHOTO);
				}
			});
	    }

	   
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean onOptionsItemSelected(MenuItem menuItem) {
	    switch (menuItem.getItemId()) {
	        //return to nextactivity when back button is clicked
	        case android.R.id.home:
	        	  Intent intent = new Intent(getApplicationContext(), NextActivity.class);
	        	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	    startActivity(intent);
	            return true;
	    }
	    return (super.onOptionsItemSelected(menuItem));
	}
	
	
	
	  @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
	        super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

	        switch(requestCode) { 
	        case SELECT_PHOTO:
	            if(resultCode == RESULT_OK){
					try {
						final Uri imageUri = imageReturnedIntent.getData();
						final InputStream imageStream = getContentResolver().openInputStream(imageUri);
						final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
						imageView.setImageBitmap(selectedImage);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

	            }
	        }
	    }
  
}
