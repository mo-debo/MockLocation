package tomloprod;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.provider.Settings.Secure;
import emulator.EmulatorDetector;
import android.os.Build;
public class FakeLocation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("check")) {
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
      if (Secure.getString(this.cordova.getActivity().getContentResolver(), Secure.ALLOW_MOCK_LOCATION).equals("0")) {
        callbackContext.success(0);
      } else {
        callbackContext.success(1);
      }
	  }
            return true;
			
        }else  if (action.equals("checkEmu")) {
		boolean isVirtual= EmulatorDetector.isEmulator();
		if (isVirtual==false)
		{
		callbackContext.success(0);
		}else {callbackContext.success(1);}

		return true;
		}
    return false;
    }
}