package template.mvc.activity.src.app_package

fun MvcActivityClass(
    applicationPackage:String?,
    activityClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName};

import ${applicationPackage}.R;
import ${applicationPackage}.base.BaseActivity;


public class ${activityClass}Activity extends BaseActivity {
    
    @Override
    protected int getLayoutID() {
        return R.layout.${layoutName};
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initData() {

    }
}
"""