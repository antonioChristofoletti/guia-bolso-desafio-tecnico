package app.model

import java.util.Date

data class Transacao (
        val data: Date,
        val descricao: String,
        val valor: Int)