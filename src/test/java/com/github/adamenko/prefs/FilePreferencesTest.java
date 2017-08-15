package com.github.adamenko.prefs;

import org.junit.Assert;
import org.junit.Test;

import java.util.prefs.Preferences;

import static com.github.adamenko.prefs.FilePreferencesFactory.SYSTEM_PROPERTY_FILE;

public class FilePreferencesTest {

    @Test
    public void test1() throws Exception {
        System.setProperty("java.util.prefs.PreferencesFactory", FilePreferencesFactory.class.getName());
        System.setProperty(SYSTEM_PROPERTY_FILE, "testprefs.txt");

        Preferences p = Preferences.userNodeForPackage(this.getClass());

        p.putBoolean("boolean.property", true);
        p.put("string.property", "custom property value");

        Assert.assertEquals(p.get("boolean.property",null), "true");
        Assert.assertEquals(p.get("string.property",null), "custom property value");
    }
}