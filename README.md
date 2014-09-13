![canopy](/img/canopy.png?raw=true)
======

Collapsible Tree List for Android

###Building
Build the library (compiles to library/build/outputs/aar/library.aar) :
```shell
$ ./gradlew :library:assembleRelease 
```

Build and install the sample:
```shell
$ ./gradlew :sample:assembleDebug

$ adb install -r sample/build/outputs/apk/sample-debug.apk
```
