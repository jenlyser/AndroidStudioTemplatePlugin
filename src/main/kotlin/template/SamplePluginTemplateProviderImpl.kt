package template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import template.mvc.activity.MvcActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        //
        return listOf(MvcActivityTemplate);
    }
}