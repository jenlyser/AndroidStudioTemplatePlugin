package org.jetbrains.plugins.template.listeners

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import org.jetbrains.plugins.template.services.MyProjectService

internal class MyProjectManagerListener : ProjectManagerListener {

    //    override fun projectOpened(project: Project) {
//        project.service<MyProjectService>()
//    }
    override fun projectOpened(project: Project) {
        projectInstance = project
        project.getService(MyProjectService::class.java)
    }

    override fun projectClosing(project: Project) {
        projectInstance = null
        super.projectClosing(project)
    }

    companion object {
        var projectInstance: Project? = null
    }
}
