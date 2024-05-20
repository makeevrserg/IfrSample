package org.company.grid.model

import org.company.core.model.ButtonType

/**
 * Single button data is used to handle buttons with only one key
 */
class SingleButtonData(val key: String, override val buttonType: ButtonType) : ButtonData
