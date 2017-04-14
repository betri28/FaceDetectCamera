FaceDetectCamera
=====================

FaceDetectCamera is a project demo Face Detection from Camera or Image, use class media.FaceDetector android. Not using 3rd library like OpenCV or Luxand FaceSDK, ...

Features built in:
  - Detect from live Camera and from Photo in Gallery.
  - Detect more face at the same time and draw exactly location in faceview.
  - Each face have a ID.
  - Auto crop small face and display in RecylerView.
  - Calulate FPS (Detected frame per second).

##Features

This project use method: convert Frame to bitmap then use media.FaceDetector detect faces in that bitmap. Have 2 ways to convert Frame to bitmap: convert to gray bitmap or convert to RGB bitmap.

  1. Convert Frame to gray bitmap so this way has **High performance** (FPS higher than RGB), butcroped of faces is gray image.
  
  2. Convert Frame to RGB bitmap, Low performance (FPS lower than Gray), but croped of faces is RGB image.



- **Detect Face from Camera**

  - Gray

      ![](https://github.com/betri28/FaceDetectCamera/raw/master/image/gray.gif)
    
    
  - RGB

      ![](https://github.com/betri28/FaceDetectCamera/raw/master/image/rgb.gif)
    
- **Detect Face from Image**

  - Demo
  
      ![](https://github.com/betri28/FaceDetectCamera/raw/master/image/image.gif)
  
##Thanks
[bytefish][bytefish] for a sample Face Detection with Android
  
Developed By
------------

* Nguyen Minh Tri - <tri2991@gmail.com>


License
--------

    Copyright 2016 Nguyen Minh Tri.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
[bytefish]:https://github.com/bytefish/VideoFaceDetection
