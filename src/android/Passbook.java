package com.jeeday.passopener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.pm.PackageManager;
import com.jeeday.passopener.PassAppAvailabilityChecker;

public class Passbook extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("openPass")) {
            String uri = args.getString(0);
            this.openPass(uri, callbackContext);
            return true;
        }
        if(action.equals("available")) {
            this.available(callbackContext);
            return true;
        }
        if(action.equals("downloadPass")) {
            String uri = args.getString(0);
            this.downloadPass(uri, callbackContext);
            return true;
        }
        if(action.equals("addPass")) {
            String uri = args.getString(0);
            this.addPass(uri, callbackContext);
            return true;
        }
        return false;
    }

    private void openPass(uri, callbackContext) {
        PassAppAvailabilityChecker passAppChecker = new PassAppAvailabilityChecker();
        if(passAppChecker.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }

    private void available(callbackContext) {
        PassAppAvailabilityChecker passAppChecker = new PassAppAvailabilityChecker();
        if(passAppChecker.checkAvailabilityOfApplications()) {
            callbackContext.success(true);
        }
        else {
            callbackContext.success(false);
        }
    }

    private void downloadPass(uri, callbackContext) {
        PassAppAvailabilityChecker passAppChecker = new PassAppAvailabilityChecker();
        if(passAppChecker.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }

    private void addPass(uri, callbackContext) {
        PassAppAvailabilityChecker passAppChecker = new PassAppAvailabilityChecker();
        if(passAppChecker.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }
}
