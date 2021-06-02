package template.mvc.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.impl.activities.common.res.values.manifestStrings


val MvcActivityTemplate
    get() = template {
        revision = 1
        name = "MVC Activity"
        description = "适用于WKing框架自定义的Activity"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Main"
            help = "只输入名字,不要包含Activity."
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字."
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )

//        thumb { File("logo.png") }
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