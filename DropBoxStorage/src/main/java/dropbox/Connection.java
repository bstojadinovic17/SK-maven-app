package dropbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.teamlog.FileOrFolderLogInfo;
import com.dropbox.core.v2.users.FullAccount;

import file.Folder;
import file.manipulation.Storage;
/**
 * Klasa Connection predstavlja implementaciju konekcije na udaljeno skladiste uz pomoc jedinstvenog ACCESS TOKENA,
 * koji je vezan za odredjeni account na Dropbox-u.
 * @author Bogi
 *
 */
public class Connection {

	//private static final String ACCESS_TOKEN = "73QM8TaW9xAAAAAAAAAALM7btVUpGJ16bq3tldeogmcgjIS_xsHXlGS5ACc-FmUL";
	/**
	 * Prilikom konekcije na dropbox, svaki korisnik je duzan da generise svoj ACCESS TOKEN koji moze pronaci u svojoj aplikaciji 
	 * dropbox accountu i da kopira taj token i prosledi ga u ovo polje pre pokretanja aplikacije.
	 */
	 private static final String ACCESS_TOKEN = "sl.A6lI0QNggftggf_0dz35ZKoy8De_fuRJ9_ZwpKLxtnCDYvI4fwUl86mPXgj62RUq6k16XYvDkodafvq-ppPy-DkszBx-KDZGD_g-my9AQiyrmjO12vDKzaZ69Fdi5i7Dhlwm4YE";

	 static DbxRequestConfig config;
	 static DbxClientV2 client;
	 static public Storage f= new Folder();	 
	 
	 static String currentFolder= "";
		static String jsonUsers="";
		static String root;
	 
	 public Connection () {
		 
	 }
	
	
	 /**
	  * Metoda za konekciju na dropbox preko dropbox API-ja
	  * @throws UploadErrorException
	  * @throws DbxException
	  * @throws IOException
	  */
	 public static void connetction() throws UploadErrorException, DbxException, IOException {
		  config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
	        client = new DbxClientV2(config, ACCESS_TOKEN);
	        
	        FullAccount account = null;
			try {
				account = client.users().getCurrentAccount();
			} catch (DbxApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (DbxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
	        //System.out.println(account.getName().getDisplayName());
	        
	        
	        
	 }
	 
	 public static DbxClientV2 getClient() {
		return client;
	}
	 public static DbxRequestConfig getConfig() {
		return config;
	}
	 
	public static String getToken(){
		 return ACCESS_TOKEN;
	 }
	 
}
