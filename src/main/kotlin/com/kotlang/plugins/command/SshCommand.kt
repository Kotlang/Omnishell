package com.kotlang.plugins.command

import com.kotlang.CommandOutput
import java.nio.file.Path
import com.jcraft.jsch.*
import com.kotlang.HistoryItem
import com.kotlang.ShellState
import com.kotlang.plugins.CommandPlugin

class SshCommand: CommandPlugin("ssh\\s.*") {
    val jsch = JSch()

    override fun execute(workingDir: Path, commandAndArgsStmt: String,
                         shellActions: ShellState, historyItem: HistoryItem) {
//        val userHost = commandAndArgsStmt[1].split("@")
//        val host = userHost[1]
//        val user = userHost[0].split(":")[0]
//        val password = user
    }
}
