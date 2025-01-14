# Versioning
This repository contains a revision tag `v.1.2.0`
Compile and execute `version` program should output `Current version: 1.2.0`



## C++

```cpp
D:\AppllicationVersioning\src>g++ version.cpp -o version.exe

D:\AppllicationVersioning\src>.\version.exe
Current Version: v1.2.0
```

## C#

```cs
D:\AppllicationVersioning\src>C:\Windows\Microsoft.NET\Framework\v3.5\csc.exe /t:exe /out:csversion.exe version.cs
Microsoft (R) Visual C# 2008 Compiler version 3.5.30729.9151
for Microsoft (R) .NET Framework version 3.5
Copyright (C) Microsoft Corporation. All rights reserved.


D:\AppllicationVersioning\src>.\csversion.exe
Current Version: v1.2.0
```

## Python

```python
python version.py
Current Version: v1.2.0
```

## Java

```java
D:\AppllicationVersioning\src>javac --version
javac 22.0.1

D:\AppllicationVersioning\src>javac -Xlint:deprecation version.java

D:\AppllicationVersioning\src>java version
Current Version: v1.2.0
```

## Javascript

```javascript
D:\AppllicationVersioning\src>node version.js
Current Version: v1.2.0
```

# Bash script

```bash
> chmod +x version.sh
> bash version.sh

Current Version: v1.2.0
```
