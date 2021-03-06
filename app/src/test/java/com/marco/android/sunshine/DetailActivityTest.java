package com.marco.android.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

import com.marco.android.sunshine.showDetails.ShowDetailsActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class DetailActivityTest {

    @Test
    public void onCreateShouldInflateTheMenu() {
        Intent intent = new Intent();
        intent.setData(Uri.EMPTY);
        ShowDetailsActivity dActivity = Robolectric.buildActivity(ShowDetailsActivity.class, intent).create().visible().get();

        Menu menu = Shadows.shadowOf(dActivity).getOptionsMenu();

        MenuItem item = menu.findItem(com.marco.android.sunshine.R.id.action_settings);
        assertEquals(item.getTitle().toString(), "Settings");
    }
}