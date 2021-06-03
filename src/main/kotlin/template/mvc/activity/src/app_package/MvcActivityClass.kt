package template.mvc.activity.src.app_package

/**
 * 这是activity的class模板,模板内容自定义,参数是传入的参数,可以更改.
 */
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