Notifier Plugin
=================

Notifier Plugin is a plugin for gradle.
This plugin provide a ability of notifying you that gradle task is finished.

# It supports only Mac
Sorry for other platform users...  
Because it uses `afplay` command for playing sound, Notification Center via apple script and `say` command for talking.  

I'll be happy, if you give me a PullRequest!

# Quick Start

## build.gradle
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'jp.tomorrowkey.gradle.notifier:notifier-plugin:0.0.1'
    }
}
```
## app/build.gradle
```
apply plugin: 'notifier-plugin'
```

# Configuration
To use this plugin, you have to make a properties file.

notifier.groovy
```
voice {
    enabled = false
    name = 'Alex'
}

notificationCenter {
    enabled = true
}

sound {
    enabled = true
    url='file:///Users/tomorrowkey/Desktop/meow.mp3'
}

beep {
    enabled = true
    count = 5
}
```

##voice
### enabled
If set true, your computer talk when gradle task is finished.
default value is `false`

### name
name of voice.

default value is `Alex`

```
Agnes               en_US    # Isn't it nice to have a computer that will talk to you?
Albert              en_US    #  I have a frog in my throat. No, I mean a real frog!
Alex                en_US    # Most people recognize me by my voice.
Bad News            en_US    # The light you see at the end of the tunnel is the headlamp of a fast approaching train.
Bahh                en_US    # Do not pull the wool over my eyes.
Bells               en_US    # Time flies when you are having fun.
Boing               en_US    # Spring has sprung, fall has fell, winter's here and it's colder than usual.
Bruce               en_US    # I sure like being inside this fancy computer
Bubbles             en_US    # Pull the plug! I'm drowning!
Cellos              en_US    # Doo da doo da dum dee dee doodly doo dum dum dum doo da doo da doo da doo da doo da doo da doo
Deranged            en_US    # I need to go on a really long vacation.
Fred                en_US    # I sure like being inside this fancy computer
Good News           en_US    # Congratulations you just won the sweepstakes and you don't have to pay income tax again.
Hysterical          en_US    # Please stop tickling me!
Junior              en_US    # My favorite food is pizza.
Kathy               en_US    # Isn't it nice to have a computer that will talk to you?
Pipe Organ          en_US    # We must rejoice in this morbid voice.
Princess            en_US    # When I grow up I'm going to be a scientist.
Ralph               en_US    # The sum of the squares of the legs of a right triangle is equal to the square of the hypotenuse.
Trinoids            en_US    # We cannot communicate with these carbon units.
Vicki               en_US    # Isn't it nice to have a computer that will talk to you?
Victoria            en_US    # Isn't it nice to have a computer that will talk to you?
Whisper             en_US    # Pssssst, hey you, Yeah you, Who do ya think I'm talking to, the mouse?
Zarvox              en_US    # That looks like a peaceful planet.
```

You can also get the above list when run `say -v "?"` on your terminal.

## notificationCenter
### enabled
If set true, Notification appeared when gradle task is finished.  
default value is `false`

## sound
### enabled
If set true, play sound when gradle task is finished.  
you need to set url property, if it is true.

### url
location of sound file.  
When use a sound file on online. just write like this.
```
url="http://example.com/sound.mp3"
```
When use a sound file on local. just write like this.
```
url="file:///Users/tomorrowkey/sound.mp3"
```

## beep
### enabled
If set true, ring beep when gradle task is finished.

### count
count of beeps for ringing

# License
```
Copyright 2014 tomorrowkey

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
