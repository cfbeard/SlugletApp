package com.sluglet.slugletapp.common.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sluglet.slugletapp.common.ext.basicRow
import com.sluglet.slugletapp.model.CourseData

/*
This is where composables for box-like items go
This includes things like:
Course information composables
Calendars
etc.
 */
@Composable
fun CourseBox(
    coursedata: CourseData,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember {mutableStateOf(false)}
    // Define a row: Left side will be the course info, right side the loc and add icons
    Row(
        modifier = modifier
            .basicRow()
            .clickable(
                onClick = { isExpanded = !isExpanded }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Organizes class data in a column structure
        Column (
            modifier = Modifier
                .padding(start = 15.dp)
        ){
            // Course Prefix and Number
            CourseText(
                modifier = Modifier,
                text = coursedata.courseNum,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            // Only show this data if the box is clicked
            if (isExpanded) {
                CourseText(
                    modifier = Modifier,
                    text = coursedata.courseName,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                CourseText(
                    modifier = Modifier,
                    text = coursedata.profName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                CourseText(
                    modifier = Modifier,
                    text = coursedata.location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                CourseText(
                    modifier = Modifier,
                    text = coursedata.dateTime,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }

        }
        // Icons
        Row (
            modifier = Modifier
                .padding(end = 15.dp),
            Arrangement.SpaceEvenly
        ){
            // TODO(CAMDEN): add clickables for icons
            Icon(Icons.Rounded.LocationOn, "map")
            Icon(Icons.Rounded.Add, "add")
        }
    }
}

@Composable
fun SearchBox (
    modifier: Modifier = Modifier
) {
    Box (
        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
    ) {
        SearchTextField()
    }
}

// Using "Split" at the top right of Android studio shows the preview of composables
@Preview (showBackground = true)
@Composable
fun CourseBoxPreview (
) {
    val test = CourseData(
        courseNum = "CSE 115A",
        courseName = "Introduction to Software Engineering",
        profName = "Richard Julig",
        dateTime = "MWF 8:00am - 9:05am",
        location = "Baskin Auditorium 1"
    )
    CourseBox(coursedata = test, modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun SearchBoxPreview (

) {
    SearchBox()
}