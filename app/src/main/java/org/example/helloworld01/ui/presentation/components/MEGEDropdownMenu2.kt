import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import org.example.helloworld01.ui.presentation.components.MEGETextField
import org.example.helloworld01.ui.presentation.components.getDefaultDiablesDropdownMenuTextColor
import org.example.helloworld01.ui.presentation.components.getDefaultDropdownMenuTextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MEGEDropdownMenu2(
    items: List<String>,
    label: String,
    enable: Boolean = true,
    expandable: Boolean = true,
    initialIndex: Int? = 0,
    isNullable: Boolean = false,
    onIndexSelected: ((Int) -> Unit)? = null
) {
    var mList = mutableListOf<String>()
    val emptyString = "-"
    if (isNullable) mList.add(emptyString)
    mList.addAll(items)

    var selectedItem by remember {
        mutableStateOf(emptyString)
    }

    if (initialIndex != null && initialIndex >= 0 && initialIndex < mList.size) {
        selectedItem = mList[initialIndex]
    }

    if (initialIndex == -1) {
        selectedItem = emptyString
    }

    var isDropDownExpanded by remember { mutableStateOf(false) }
    var isItemSelected by remember { mutableStateOf(false) }
    var itemPosition = if(!mList.isEmpty()) mList.indexOf(selectedItem) else initialIndex
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .onGloballyPositioned { coordinates ->
                // This value is used to assign to
                // the DropDown the same width
                mTextFieldSize = coordinates.size.toSize()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    if(!enable) {
                        isDropDownExpanded = false
                    }else{
                        isDropDownExpanded = !isDropDownExpanded
                    }
                }
            ) {
                if (mList.isEmpty()) {
                    MEGETextField(
                        value = emptyString,
                        onValueChange = {},
                        label = label,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = false
                            )
                        },
                        colors = if (enable) getDefaultDropdownMenuTextColor(isItemSelected) else getDefaultDiablesDropdownMenuTextColor(
                            isItemSelected
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                // This value is used to assign to
                                // the DropDown the same width
                                mTextFieldSize = coordinates.size.toSize()
                            },
                    )
                } else {
                    MEGETextField(
                        value = mList[itemPosition!!],
                        onValueChange = {},
                        label = label,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = if (!expandable) {
                                    false
                                } else {
                                    isDropDownExpanded
                                }
                            )
                        },
                        colors = if (enable) getDefaultDropdownMenuTextColor(isItemSelected) else getDefaultDiablesDropdownMenuTextColor(
                            isItemSelected
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                // This value is used to assign to
                                // the DropDown the same width
                                mTextFieldSize = coordinates.size.toSize()
                            },
                    )
                }

                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = isDropDownExpanded,
                )
            }
            DropdownMenu(
                modifier = Modifier
                    .background(Color.White),
                expanded = isDropDownExpanded,
                onDismissRequest = {
                    isDropDownExpanded = false
                }) {
                mList.forEachIndexed { index, username ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() }),
                        onClick = {
                            isDropDownExpanded = false
                            itemPosition = index
                            if (isNullable) {
                                if (onIndexSelected != null) {
                                    onIndexSelected(index - 1)
                                }
                                isItemSelected = index > 0
                            } else {
                                if (onIndexSelected != null) {
                                    onIndexSelected(index)
                                }
                                isItemSelected = true
                            }
                        },
                        text = {
                            Text(
                                text = username,
                                fontStyle = if (username == "Empty String") FontStyle.Italic else FontStyle.Normal,
                            )
                        }
                    )
                }
            }
        }
    }
}