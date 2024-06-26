package com.flipperdevices.ifrmvp.backend.db.signal.table

import org.jetbrains.exposed.dao.id.LongIdTable

object SignalTable : LongIdTable("SIGNAL_TABLE") {
    val categoryId = reference("category_id", CategoryTable)
    val brandId = reference("brand_id", BrandTable)
    val ifrFileId = reference("ifr_file_id", IfrFileTable)
    val name = text("name")
    val type = text("type")
    val protocol = text("protocol").nullable()
    val address = text("address").nullable()
    val command = text("command").nullable()
    val frequency = text("frequency").nullable()
    val dutyCycle = text("duty_cycle").nullable()
    val data = text("data").nullable()
    val hash = text("hash")
}
