# EasyDataStore

<h5><b>Introduction</b></h5>
<p>
Hello Everyone, 
This dependency is used to Data store. Data store is a library that can help to store the data in app preference.
In this dependency you can access Data Store Preferences type. \n
As we know Shared Preference is deprecated in android and used a Data Store library in android.
But Data store used in your android app they can give many issues. In this library you can only add
library and access all function to store data without any error or issues. 
</p>
<br>
<h5>Dependency</h5>

 1.) First need to add data store in your app
  
    //DataStore
        implementation "androidx.datastore:datastore-preferences:1.0.0-alpha06"
        implementation "androidx.datastore:datastore-core:1.0.0-alpha06"
 
     //Coroutines and LifeCycle Libraries
         implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1"
         
         
 2.) Second add this dependency in your project for data store setup
 
     //Data Store  Setup
      Step 1. Add the JitPack repository to your build file
      Add it in your root build.gradle at the end of repositories:

       allprojects {
         repositories {
           ...
           maven { url 'https://jitpack.io' }
         }
       }
       
      Step 2. Add the dependency
       dependencies {
               implementation 'com.github.rajputmukesh748:EasyDataStore:1.0.0'
       }


<h6>Implementation</h6>
 1.) Initialize Data Store in Application class 
          
    class AppController : Application() {
    
        override fun onCreate() {
            super.onCreate()
            CallDataStore.initializeDataStore(
                context = applicationContext,
                dataBaseName = "DemoAppData"
            )
        }
    
    }
    
    
 2.) Add this class in your manifest file
 
     <application
             android:name=".AppController"
             ....
             >
             .....
     </application>
     
     
 3.) Create a Preferences keys for store data in particular key.
       Each data type key are available in this dependency. 
       You just need to first enter which data type key used for store data.
       Then call getDataPreferenceKey() function with pass unique key in string.  
 
    val INT_KEY = Int.getDataPreferenceKey("loginData")
    val DOUBLE_KEY = Double.getDataPreferenceKey("loginData")
    val STRING_KEY = String.getDataPreferenceKey("loginData")
    val BOOLEAN_KEY = Boolean.getDataPreferenceKey("loginData")
    val FLOAT_KEY = Float.getDataPreferenceKey("loginData")
    val LONG_KEY = Long.getDataPreferenceKey("loginData")
    
    
 4.) For store data in Data Store
 
    CallDataStore.storeData(key = STRING_KEY, storeData = storeData)
    
    
 5.) Get stored data with key
 
     CallDataStore.getPreferenceData(STRING_KEY){
            Log.e("skdnaskndkasdasd", "${it}")
     }
     
     
 6.) Clear unique key data from app
 
     CallDataStore.clearKeyData(STRING_KEY)
    
     
 7.) Clear all preference data from app. They will clear each and every key data.
 
    CallDataStore.clearAllData()
    
    
 <b>Thank you.</b>
