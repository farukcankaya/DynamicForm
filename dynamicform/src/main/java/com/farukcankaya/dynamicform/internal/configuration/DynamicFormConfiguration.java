package com.farukcankaya.dynamicform.internal.configuration;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class DynamicFormConfiguration {

    public interface Arguments {
        String REQUEST_CODE = "com.farukcankaya.dynamicform.configuration.request_code";
        String FORM = "com.farukcankaya.dynamicform.configuration.form";
    }

    private Activity activity;
    private Fragment fragment;
    private int requestCode;
    private String form;

    private DynamicFormConfiguration(Activity activity) {
        this.activity = activity;
    }

    private DynamicFormConfiguration(Fragment fragment) {
        this.fragment = fragment;
    }

    public static class Builder {
        private DynamicFormConfiguration dynamicFormConfiguration;

        public Builder(Activity activity) {
            dynamicFormConfiguration = new DynamicFormConfiguration(activity);
        }

        public Builder(Fragment fragment) {
            dynamicFormConfiguration = new DynamicFormConfiguration(fragment);
        }

        public Builder setRequestCode(int requestCode) {
            dynamicFormConfiguration.requestCode = requestCode;
            return this;
        }

        public Builder setForm(String form) {
            dynamicFormConfiguration.form = form;
            return this;
        }

        public DynamicFormConfiguration build() {
            return dynamicFormConfiguration;
        }
    }

    public Activity getActivity() {
        return activity;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public String getForm() {
        return form;
    }
}
