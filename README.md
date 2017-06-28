# preferencex
Library that extends Java Preferences API to work with  file as the storage

## Usage

```
System.setProperty("java.util.prefs.PreferencesFactory", FilePreferencesFactory.class.getName());
System.setProperty(SYSTEM_PROPERTY_FILE, "myprefs.txt");

Preferences p = Preferences.userNodeForPackage(this.getClass());

p.putBoolean("boolean.property", true);
p.put("string.property", "custom.property.value");

System.out.println("boolean.property: " + p.get("boolean.property", null));
System.out.println("string.property: " + p.get("string.property", null));
```

will return

```
boolean.property: true
string.property: custom.property.value
```