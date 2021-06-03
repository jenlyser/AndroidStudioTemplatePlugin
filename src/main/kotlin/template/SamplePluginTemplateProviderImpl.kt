package template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import template.mvc.activity.MvcActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        //返回需要创建的文件模板的列表,必不可少的,不然右键点击无效.
        return listOf(MvcActivityTemplate);
    }
}