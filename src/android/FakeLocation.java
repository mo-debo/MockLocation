package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.provider.Settings.Secure;
import android.os.Build;
import android.location.Location;
import com.esri.cordova.geolocation.controllers.GPSController;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;
public class FakeLocation extends CordovaPlugin 
{

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException 
    {
        if (action.equals("check")) 
       {
          if (Build.VERSION.SDK_INT < 18)
             {
			if (Secure.getString(this.cordova.getActivity().getContentResolver(), Secure.ALLOW_MOCK_LOCATION).equals("0")) 
                        {
				callbackContext.success(0);
			} else {
				callbackContext.success(1);
			}
                        return true;
             }
              else
             {
                int count = 0;
        Context context = this.cordova.getActivity().getApplicationContext();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages =
                pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo applicationInfo : packages) {
            try {
                PackageInfo packageInfo = pm.getPackageInfo(applicationInfo.packageName,
                        PackageManager.GET_PERMISSIONS);

                // Get Permissions
                String[] requestedPermissions = packageInfo.requestedPermissions;

                if (requestedPermissions != null) {
                    for (int i = 0; i < requestedPermissions.length; i++) {
                        if (requestedPermissions[i]
                                .equals("android.permission.ACCESS_MOCK_LOCATION")
                                && !applicationInfo.packageName.equals("AndalousMobile")) {
                            count++;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
             }
        }
		return false;
    }
}