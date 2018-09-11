# -*- coding: utf-8 -*-
"""
Created on Sat May 19 03:23:15 2018

@author: MOHAMMAD AMIN
"""
import cv2

import matplotlib.pyplot as plt

import numpy as np



image = cv2.imread('lady-gaga.jpg')

image1 = cv2.imread('lady-gaga.jpg' , cv2.IMREAD_GRAYSCALE)

image2 = cv2.imread('lady-gaga.jpg' , cv2.IMREAD_COLOR)

image3 = cv2.imread('lady-gaga.jpg' , cv2.IMREAD_UNCHANGED)

cv2.imshow("lady" , image1)

cv2.imwrite("lagy-gaga2.jpg" , image1)

cv2.waitKey(0)

cv2.destroyAllWindows()