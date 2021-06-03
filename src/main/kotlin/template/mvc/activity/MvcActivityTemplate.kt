package template.mvc.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * 定义新建文件框的模板,界面上显示的可编辑的控件,并获取值传入生成模板的方法.
 */
val MvcActivityTemplate
    get() = template {
        revision = 1 //版本
        name = "MVC Activity" //右键new->显示的名称
        description = "适用于WKing框架自定义的Activity" //新建模板的描述
        minApi = MIN_API //最低的api,
        minBuildApi = MIN_API //最低的build api

        category = Category.Activity //右键 new->显示在那个分类里面
        formFactor = FormFactor.Mobile //适用的设备
        //可显示的位置
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )
        //activity 输入框
        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Main"
            help = "只输入名字,不要包含Activity."
            constraints = listOf(Constraint.NONEMPTY)
        }
        //layout 输入框
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字."
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }
        //包名输入框
        val packageName = defaultPackageNameParameter

        //输入的控件
        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )

        //thumb { File("logo.png") }//自定义图标
        //创建文件的模板
        recipe = { data: TemplateData ->
            MvcActivityRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                layoutName.value,
                packageName.value
            )
        }


    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.wking.app"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }