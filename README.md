[![](https://jitpack.io/v/SayHiEveryday/PandaKey-Implement.svg)](https://jitpack.io/#SayHiEveryday/PandaKey-Implement)


<img align="right" src="https://pandadevelopment.net/images/logo.png" alt="">

# 🐼 Panda key Implementation

This is open source lib implement from [PandaDevelopment's lua v2 lib](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua)
<br>
Provided basic function like [GetKey](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua#L159), [Key Validation](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua#L191)

## 🛠️ Installation

Install Using [jitpack](https://jitpack.io/)

Start by add this to `build.gradle`
```gradle
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

Then add implementation to dependencies
```gradle
dependencies {
    implementation 'com.github.SayHiEveryday:PandaKey-Implement:VERSION'
}
```

Change the version to latest version see [Release](https://github.com/SayHiEveryday/PandaKey-Implement/releases)

## 📖 Getting Started

Start by Import necessary class and creating instance of PandaKey

```java
import me.sallyio.PandaKey.PandaKey;
import me.sallyio.PandaKey.common.IdentifierProvider;

public class Main {
    public static void main(String[] args) {
        // Retrieve a unique hardware identifier using the IdentifierProvider class.
        String identifier = IdentifierProvider.getHardwareIdentifier();

        // Create PandaKey Object with service name and hardware identifier.
        PandaKey pandakey = PandaKey.newBuilder("Service name")
                .setIdentifier(identifier)
                .build();

        // Generate the key link using the PandaKey instance.
        String keyLink = pandakey.getKey();
        System.out.println("Key Link: " + keyLink);
    }
}
```

We offer utility classes such as BrowserUtil to streamline the process of launching a web browser within your application.
```java
import me.sallyio.PandaKey.common.BrowserUtil;

public class Main {
    public static void main(String[] args) {
        // Create an instance of PandaKey with a specified service name and identifier
        PandaKey pandakey = PandaKey.newBuilder("Your Service Name")
                .setIdentifier("Identifier")
                .build();

        // Open the browser using the generated key
        BrowserUtil.open(pandakey.getKey());
    }
}

```
