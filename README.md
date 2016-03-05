Notifier Plugin
=================

Notifier Plugin is a plugin for gradle.  
This plugin provides an ability of notifying you that gradle task is finished.

# It supports only Mac
Sorry for other platform users...  
Because it uses `afplay` command for playing sound, Notification Center via apple script and `say` command for talking.  
Beep may work on other platform.  

I'll be happy, if you give me a PullRequest!

# Quick Start

## build.gradle
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'jp.tomorrowkey.gradle.notifier:notifier-plugin:1.0.1'
    }
}
```
## app/build.gradle
```
apply plugin: 'notifier-plugin'
```

# Configuration
To use this plugin, you have to make a configuration file.

notifier.properties

```
voice.enabled=false
voice.name=Alex

notificationCenter.enabled=true

sound.enabled=true
sound.url=file:///Users/tomorrowkey/Desktop/meow.mp3

beep.enabled=true
beep.count=5
```

##voice
### enabled
If set true, your computer talks when gradle task is finished.
default value is `false`

### name
name of voice. default value is `Alex`. You can use following names on OSX Yosemite.

```
Agnes               en_US    # Isn't it nice to have a computer that will talk to you?
Albert              en_US    #  I have a frog in my throat. No, I mean a real frog!
Alex                en_US    # Most people recognize me by my voice.
Alice               it_IT    # Salve, mi chiamo Alice e sono una voce italiana.
Alva                sv_SE    # Hej, jag heter Alva. Jag är en svensk röst.
Amelie              fr_CA    # Bonjour, je m’appelle Amelie. Je suis une voix canadienne.
Anna                de_DE    # Hallo, ich heiße Anna und ich bin eine deutsche Stimme.
Bad News            en_US    # The light you see at the end of the tunnel is the headlamp of a fast approaching train.
Bahh                en_US    # Do not pull the wool over my eyes.
Bells               en_US    # Time flies when you are having fun.
Boing               en_US    # Spring has sprung, fall has fell, winter's here and it's colder than usual.
Bruce               en_US    # I sure like being inside this fancy computer
Bubbles             en_US    # Pull the plug! I'm drowning!
Carmit              he_IL    # שלום. קוראים לי כרמית, ואני קול בשפה העברית.
Cellos              en_US    # Doo da doo da dum dee dee doodly doo dum dum dum doo da doo da doo da doo da doo da doo da doo
Damayanti           id_ID    # Halo, nama saya Damayanti. Saya berbahasa Indonesia.
Daniel              en_GB    # Hello, my name is Daniel. I am a British-English voice.
Deranged            en_US    # I need to go on a really long vacation.
Diego               es_AR    # Hola, me llamo Diego y soy una voz española.
Ellen               nl_BE    # Hallo, mijn naam is Ellen. Ik ben een Belgische stem.
Fiona               en-scotland # Hello, my name is Fiona. I am a Scottish-English voice.
Fred                en_US    # I sure like being inside this fancy computer
Good News           en_US    # Congratulations you just won the sweepstakes and you don't have to pay income tax again.
Hysterical          en_US    # Please stop tickling me!
Ioana               ro_RO    # Bună, mă cheamă Ioana . Sunt o voce românească.
Joana               pt_PT    # Olá, chamo-me Joana e dou voz ao português falado em Portugal.
Junior              en_US    # My favorite food is pizza.
Kanya               th_TH    # สวัสดีค่ะ ดิฉันชื่อKanya
Karen               en_AU    # Hello, my name is Karen. I am an Australian-English voice.
Kathy               en_US    # Isn't it nice to have a computer that will talk to you?
Kyoko               ja_JP    # こんにちは、私の名前はKyokoです。日本語の音声をお届けします。
Laura               sk_SK    # Ahoj. Volám sa Laura . Som hlas v slovenskom jazyku.
Lekha               hi_IN    # नमस्कार, मेरा नाम लेखा है.Lekha[[FEMALE_NAME]]मै हिंदी मे बोलने वाली आवाज़ हूँ.
Luciana             pt_BR    # Olá, o meu nome é Luciana e a minha voz corresponde ao português que é falado no Brasil
Mariska             hu_HU    # Üdvözlöm! Mariska vagyok. Én vagyok a magyar hang.
Mei-Jia             zh_TW    # 您好，我叫美佳。我說國語。
Melina              el_GR    # Γεια σας, ονομάζομαι Melina. Είμαι μια ελληνική φωνή.
Milena              ru_RU    # Здравствуйте, меня зовут Milena. Я – русский голос системы.
Moira               en_IE    # Hello, my name is Moira. I am an Irish-English voice.
Monica              es_ES    # Hola, me llamo Monica y soy una voz española.
Nora                nb_NO    # Hei, jeg heter Nora. Jeg er en norsk stemme.
Paulina             es_MX    # Hola, me llamo Paulina y soy una voz mexicana.
Pipe Organ          en_US    # We must rejoice in this morbid voice.
Princess            en_US    # When I grow up I'm going to be a scientist.
Ralph               en_US    # The sum of the squares of the legs of a right triangle is equal to the square of the hypotenuse.
Samantha            en_US    # Hello, my name is Samantha. I am an American-English voice.
Sara                da_DK    # Hej, jeg hedder Sara. Jeg er en dansk stemme.
Satu                fi_FI    # Hei, minun nimeni on Satu. Olen suomalainen ääni.
Sin-ji              zh_HK    # 您好，我叫 Sin-ji。我講廣東話。
Tarik               ar_SA    # مرحبًا اسمي Tarik. أنا عربي من السعودية.
Tessa               en_ZA    # Hello, my name is Tessa. I am a South African-English voice.
Thomas              fr_FR    # Bonjour, je m’appelle Thomas. Je suis une voix française.
Ting-Ting           zh_CN    # 您好，我叫Ting-Ting。我讲中文普通话。
Trinoids            en_US    # We cannot communicate with these carbon units.
Veena               en_IN    # Hello, my name is Veena. I am an Indian-English voice.
Vicki               en_US    # Isn't it nice to have a computer that will talk to you?
Victoria            en_US    # Isn't it nice to have a computer that will talk to you?
Whisper             en_US    # Pssssst, hey you, Yeah you, Who do ya think I'm talking to, the mouse?
Xander              nl_NL    # Hallo, mijn naam is Xander. Ik ben een Nederlandse stem.
Yelda               tr_TR    # Merhaba, benim adım Yelda. Ben Türkçe bir sesim.
Yuna                ko_KR    # 안녕하세요. 제 이름은 Yuna입니다. 저는 한국어 음성입니다.
Zarvox              en_US    # That looks like a peaceful planet.
Zosia               pl_PL    # Witaj. Mam na imię Zosia, jestem głosem kobiecym dla języka polskiego.
Zuzana              cs_CZ    # Dobrý den, jmenuji se Zuzana. Jsem český hlas.
```

You can also get the above list by run `say -v "?"` on your terminal.

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
default value is false

### count
count of beeps for ringing  
default value is 3

# Open Source License

This plugin made with [gradle-plugin-template](https://github.com/gfx/gradle-plugin-template)

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
