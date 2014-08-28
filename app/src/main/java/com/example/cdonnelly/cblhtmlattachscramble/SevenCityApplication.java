package com.example.cdonnelly.cblhtmlattachscramble;

import java.io.IOException;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

/**
 * @author docallaghan
 * 
 *  Main application class, holds the MVC model
 * 
 */
public class SevenCityApplication extends Application {
	
	private final static String TAG = SevenCityApplication.class.getSimpleName();
	
	private final static String DB_NAME = "FitchMobilePortal";

	/** If true then strict mode is enabled */
	private static final boolean STRICT = false;


	
	/** Instance of the CouchbaseLite {@link Manager} */
	private static Manager mDbManager;
	
	//private static Database mStructuralDatabase;
	
	//private static Database mUserDatabase;
	
	private static Context mContext;



	@Override
	public void onCreate() {
		try {
			mContext = getApplicationContext();
			mDbManager = new Manager(new AndroidContext(mContext), Manager.DEFAULT_OPTIONS);
			
		} catch (IOException e) {
			e.printStackTrace();
		    Log.d(TAG, "Cannot create database");
		    return;
		}
	}




	



	
	public static Database getDatabase(String dbName) throws CouchbaseLiteException {
		if (!Manager.isValidDatabaseName(dbName)) {
            return null;
        }

		return mDbManager.getDatabase(dbName);
	}
	
	public static void createStructuralViews(String dbName) throws CouchbaseLiteException {
		Database database = mDbManager.getDatabase(dbName);
		//DBUtils.createMenuView(database, mContext);
		//DBUtils.createNodeView(database, mContext);
		//DBUtils.createRecordingView(database, mContext);
		//DBUtils.createPdfView(database, mContext);
		DBUtils.createHtmlView(database, mContext);
		//DBUtils.createHelpdeskView(database, mContext);
		//DBUtils.createBookmarkView(database, mContext);
		//DBUtils.createTextView(database, mContext);
		//DBUtils.createQuestionView(database, mContext);
	}
	
	public static void createUserViews(String dbName) throws CouchbaseLiteException {
		Database database = mDbManager.getDatabase(dbName);
		//DBUtils.createTimestampView(database, mContext);
		//DBUtils.createUserBookmarkView(database, mContext);
		//DBUtils.createUserHelpdeskView(database, mContext);
		//DBUtils.createNotificationView(database, mContext);
		//DBUtils.createUserQuizView(database, mContext);
		//DBUtils.createModificationView(database, mContext);
	}
}
