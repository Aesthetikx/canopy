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

###Usage

####Add The ListView
Canopy operates on a standard ListView.

```java
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.comments_list);

        // rootComment is an object that implements CanopyItem
        // (see the next section)

        CanopyAdapter adapter = new CanopyAdapter(this, rootComment);
        CanopyItemClickListenr listener = new CanopyItemClickListenr(adapter);

        list.setAdapter(adapter);
        list.setOnItemClickListener(listener);
        
        // ...

    }

    // ...
}

```

####Implement CanopyItem
The easiest way to implement CanopyItem is to extend BaseCanopyItem in your
model.

```java
public class Comment extends BaseCanopyItem {
```

The constructor should take a List<CanopyItem> of children, and the depth of
this node.

```java
    public Comment(List<CanopyItem> children, int depth, ...) {
        super(true, true, depth, children);

        // ...
    }
```

Finally, you should override getExpandedView and getCollapsedView.

```java
    @Override
    public void getExpandedView(LayoutInflater inflater, ViewGroup parent) {
        CanopyRowView canopyRow = 
            (CanopyRowView) super.getExpandedView(inflater, parent);

        LinearLayout content = canopyRow.getContentLayout();

        // Here, expand your views and add them to the content view

        content.addView(myContent);

        return canopyRow;
    }

    @Override
    public void getCollapsedView(LayoutInflater inflater, ViewGroup parent) {

        // Handle the same as above

    }
```

####Changing Depth Indicator Colors
Canopy handles level indicator colors with the ColorProvider interface. To
change the colors that are displayed, override getColorProvider in your model
with either a class that implements ColorProvider, or anonymously.

```java
    @Override
    public ColorProvider getColorProvider() {
        return new ColorProvider() {
            @Override
            public int getColor(int depth) {
                // Return red for even depths, blue for odd
                if (depth % 2 == 0) {
                    return Color.RED;
                } else {
                    return Color.BLUE;
                }
            }
        }
    }
```
