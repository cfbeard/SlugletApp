package com.sluglet.slugletapp.screens.map

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.sluglet.slugletapp.OSMaps.CameraPositionState
import com.sluglet.slugletapp.OSMaps.Marker
import com.sluglet.slugletapp.OSMaps.OSMaps
import com.sluglet.slugletapp.OSMaps.rememberCameraPositionState
import com.sluglet.slugletapp.R
import com.sluglet.slugletapp.common.composables.CourseMarker
import com.sluglet.slugletapp.model.CourseData
import com.sluglet.slugletapp.resources
import org.osmdroid.util.GeoPoint


@Composable
fun MapScreen (
    openScreen: (String) -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    // Gets state from the view model for the camera position
    val cameraPositionState = viewModel.cameraState.value
    // Use this modifier to modify the look of the map
    val mapModifier = Modifier
        .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(elevation = 10.dp)
    // FIXME: Remove
    val test = CourseData (
        course_number = "CSE 115A",
        course_name = "Intro to Software Engineering",
        location = "Baskin Auditorium 1",
        date_time = "MWF 8:00am-9:00am",
        prof_name = "Julig",
        coord = GeoPoint(37.00038024521826, -122.06233134599164)
    )
    OSMaps (
        cameraPositionState = cameraPositionState,
        modifier = mapModifier
    ) {
        CourseMarker(
            course = test,
            // custom marker
            markerIcon = ResourcesCompat.getDrawable(resources(), R.drawable.edu_map_pin, null)
        )
    }
}