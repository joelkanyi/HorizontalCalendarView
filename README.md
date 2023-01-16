# HorizontalCalendarView
A Jetpack Compose Horizontal Calendar View Library

To use the library in your project:

### Step 1. Add the JitPack repository to your build file

#### Add it in your root build.gradle at the end of repositories:
```gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```
## Step 2. Add the dependency
```gradle
    dependencies {
        implementation 'com.github.JoelKanyi:HorizontalCalendarView:1.0.0'
    }
```

## Usage
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

## Demo
<img src="screenshots/demo.jpg" width="250"/>
