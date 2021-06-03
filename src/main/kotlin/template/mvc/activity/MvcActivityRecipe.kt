package template.mvc.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import template.mvc.activity.res.layout.MvcActivityXml
import template.mvc.activity.src.app_package.MvcActivityClass

/**
 * 创建文件模板的构建类.
 */
fun RecipeExecutor.MvcActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val projectTemplateData = moduleData.projectTemplateData //获取模板数据

    val ktOrJavaExt = projectData.language.extension //获取文件后缀
    //在Manifest.xml文件创建<activity>标签
    generateManifest(
            moduleData = moduleData,
            activityClass = "${activityClass}Activity",
            activityTitle = activityClass,
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false
    )
    //这里可以generate 多种文件
    //也可以构建多种不同类型的文件以及保存不同类型的文件.

    //构建activity 文件
    val mvcActivity = MvcActivityClass(
        projectTemplateData.applicationPackage,
        activityClass,
        layoutName,
        packageName
    )
    // 保存Activity 文件
    save(mvcActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 构建并且保存xml 文件
    save(MvcActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

}