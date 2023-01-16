<h1 align="center">HorizontalCalendarView</h1></br>

<p align="center">
:calendar: A Jetpack Compose Horizontal Calendar View Library for your Android projects.
</p>
</br>

## Including it in your project:

#### Step 1. Add the JitPack repository to your root `build.gradle` file
```gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

#### Step 2. Add the dependency
```gradle
    dependencies {
        implementation 'com.github.JoelKanyi:HorizontalCalendarView:1.0.0'
    }
```

#### Usage
Add the `HorizontalCalendarView` composable into your project and customize it according to your needs:
```kotlin
HorizontalCalendarView(
    modifier = Modifier,
    selectedTextColor = Color.White,
    unSelectedTextColor = Color.Black,
    selectedCardColor = Color.Blue,
    unSelectedCardColor = Color.LightGray,
    onDayClick = { day ->
        Toast.makeText(context, day.toString(), Toast.LENGTH_SHORT).show()
    }
)
```

#### Demo
<img src="screenshots/demo.jpg" width="250"/>
