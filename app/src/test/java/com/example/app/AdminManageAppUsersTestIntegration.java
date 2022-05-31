package com.example.app;

import static org.junit.Assert.assertEquals;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

@Config(sdk = 29, packageName="com.example.app")
@RunWith(RobolectricTestRunner.class)
public class AdminManageAppUsersTestIntegration {

    @Test
    public void clickingGetStarted() {
        SignInActivity activityB = Robolectric.setupActivity(SignInActivity.class);
//        SignInActivity activityB = Robolectric.setupActivity(SignInActivity.class);
//        EditText mail = (EditText) activityB.findViewById(R.id.email);
//        EditText pw = (EditText) activityB.findViewById(R.id.password);
//        mail.setText("adam370@hotmail.fr");
//        pw.setText("secret");
//        activityB.findViewById(R.id.email_sign_in_button).performClick();

        AdminManageAppUsers activity = Robolectric.setupActivity(AdminManageAppUsers.class);
        activity.findViewById(R.id.mikveh_button).performClick();

        Intent expectedIntent = new Intent(activity, MikvehListActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();

        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }
}