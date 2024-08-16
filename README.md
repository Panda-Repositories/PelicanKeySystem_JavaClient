<img align="right" src="https://pandadevelopment.net/images/logo.png" alt="">

# Panda key Implementation

This is open source lib implement from [PandaDevelopment's lua v2 lib](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua)
<br>
Provided basic function like [GetKey](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua#L159), [Key Validation](https://github.com/Panda-Repositories/PandaKS_Libraries/blob/main/library/LuaLib/ROBLOX/PandaBetaLib.lua#L191)

## Installation 
**TODO**

## Getting Started

Start by Import necessary class and creating instance of PandaKey

```java
import me.sallyio.PandaKey.PandaKey;
import me.sallyio.PandaKey.common.IdentifierProvider;

public class Main {
    public static void main(String[] args) throws Exception {
        // Retrieve a unique hardware identifier using the IdentifierProvider class.
        String identifier = IdentifierProvider.getHardwareIdentifier();

        // Instantiate a PandaKey object with the specified service name and hardware identifier.
        PandaKey pandakey = PandaKey.newBuilder("Service name")
                .setIdentifier(identifier)
                .build();

        // Generate the key link using the PandaKey instance.
        String keyLink = pandakey.getKey();
        System.out.println("Key Link: " + keyLink);
    }
}
```

We provide class like BrowserUtil so you can open browser easily
```java
import me.sallyio.PandaKey.common.BrowserUtil;

public class Main {
    public static void main(String[] args) {
        PandaKey pandakey = PandaKey.newBuilder("Your Service Name").setIdentifier("Identifier").build();
        BrowserUtil.open(pandakey.getKey());
    }
}
```
