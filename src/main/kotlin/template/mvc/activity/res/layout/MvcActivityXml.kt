package template.mvc.activity.res.layout


fun MvcActivityXml(
    packageName: String,
    activityClass: String
) = """
    <?xml version="1.0" encoding="utf-8"?>

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.common.ComparisonActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:ignore="MissingConstraints">

        <FrameLayout
            android:id="@+id/recovery_top"
            android:layout_width="match_parent"
            android:layout_height="@dimen/dp_107"></FrameLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:orientation="vertical">

            <include layout="@layout/item_title_main"></include>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="@dimen/dp_0"
                android:layout_weight="1"
                android:gravity="center_horizontal"
                android:orientation="vertical">

            </LinearLayout>


        </LinearLayout>

        <FrameLayout
            android:id="@+id/recovery_bottom"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:minHeight="@dimen/dp_40"></FrameLayout>
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
"""