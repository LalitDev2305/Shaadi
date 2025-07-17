package com.assignment.home.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.assignment.domain.models.RandomResult

@Composable
fun UserCard(
    user: RandomResult, onAccept: () -> Unit, onDecline: () -> Unit
) {
    val localUser = remember {
        UserLocalTuple(
            gender = "Male",
            city = "Mumbai",
            state = "Maharashtra",
            country = "India",
            age = 36, // Close to one of them
            nat = "IND"
        )
    }

    val matchPercent = remember(user) {
        calculateMatchPercentage(localUser, user)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = user.picture.large,
                    contentDescription = "User Image",
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${user.name.first} ${user.name.last}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "${user.location.city}, ${user.location.country}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                when (user.status) {
                    "accepted" -> {
                        Text("Accepted", color = MaterialTheme.colorScheme.primary)
                    }

                    "decline" -> {
                        Text("Rejected", color = MaterialTheme.colorScheme.error)
                    }

                    else -> {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                        ) {
                            IconButton(
                                onClick = { onAccept() },
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Accept",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }

                            IconButton(
                                onClick = { onDecline() },
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.error.copy(alpha = 0.15f),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Decline",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }

            // 🎯 Matching Percentage at Top-Right
            Text(
                text = "Match: $matchPercent%",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

@Composable
fun UserCardShimmer() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShimmerLoadingBox(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            ShimmerLoadingBox(
                modifier = Modifier
                    .height(20.dp)
                    .width(120.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            ShimmerLoadingBox(
                modifier = Modifier
                    .height(16.dp)
                    .width(100.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                repeat(2) {
                    ShimmerLoadingBox(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}

@Composable
fun ShimmerLoadingBox(
    modifier: Modifier = Modifier, shape: Shape = RoundedCornerShape(8.dp)
) {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f, targetValue = 1000f, animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing), repeatMode = RepeatMode.Restart
        ), label = "shimmer_anim"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.3f),
            Color.LightGray.copy(alpha = 0.6f),
        ),
        start = Offset(translateAnim, translateAnim),
        end = Offset(translateAnim + 200f, translateAnim + 200f)
    )

    Spacer(
        modifier = modifier.background(shimmerBrush, shape)
    )
}

fun calculateMatchPercentage(local: UserLocalTuple, remote: RandomResult): Int {
    var score = 5f

    if (!remote.gender.equals(local.gender, ignoreCase = true)) {
        score += 30
    }

    if (kotlin.math.abs(remote.dob.age - local.age) <= 8) {
        score += 20
    }

    if (remote.location.state.equals(local.state, ignoreCase = true) || remote.location.city.equals(
            local.city, ignoreCase = true
        )
    ) {
        score += 15
    }

    if (remote.location.country.equals(local.country, ignoreCase = true)) {
        score += 10
    }

    if (remote.nat.equals(local.nat, ignoreCase = true)) {
        score += 5
    }

    return score.toInt().coerceAtMost(99)
}
