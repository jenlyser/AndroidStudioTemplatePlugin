package template.mvc.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import template.mvc.activity.res.layout.MvcActivityXml
import template.mvc.activity.src.app_package.MvcActivityClass

fun RecipeExecutor.MvcActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val projectTemplateData = moduleData.projectTemplateData

    val ktOrJavaExt = projectData.language.extension
    generateManifest(
            moduleData = moduleData,
            activityClass = "${activityClass}Activity",
            activityTitle = activityClass,
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false
    )
//    generateManifest(
//
//    )


    val mvcActivity = MvcActivityClass(
        projectTemplateData.applicationPackage,
        activityClass,
        layoutName,
        packageName
    )
    // 保存Activity
    save(mvcActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(MvcActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

}