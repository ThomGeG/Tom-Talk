# Tom-Talk [![Build Status](https://travis-ci.org/ThomGeG/Tom-Talk.svg?branch=master)](https://travis-ci.org/ThomGeG/Tom-Talk)
A small live web-chat application utilizing Web-Sockets, OAuth 2.0, Spring, and whatever else I can cram into it!

## Description
Tom-Talk is a small live web-chat application I made as a journey into Spring, Single Sign On services such as Facebook's, and in general a more complete web development experience. 

It's currently a very minimal and barebones service that at its core just forwards plain-text messages recieved by the server to the subscribed clients akin to any other live web-chat you've heard of. There is no support for emojis or text markdown, just regular plain-text inside a half-way decent UI.

## Screenshots
TODO

Alternatively, you can interact with a live version of the application [here](http://tom-talk.us-east-2.elasticbeanstalk.com/)! Just be warned, there is currently no sanitation of user inputs and XSS attacks are a possibility on the infinitesimally small chance somebody else is using the service at the same time as you.

## Getting Started & Deployement
TODO

## Built with...
- Java - No judgement please...
- Maven - For dependancy & build management
- Spring - The backbone of the service and framework of choice that ties it all together
- Spring Security - For authentication & authorization without the boilerplate.
- Bootstrap - Providing versatile and sleek CSS for the aesthetically impaired since 2011
- SockJS - Client side JavaScript for convenient messaging via a simple facade

## See also
- https://spring.io/guides/tutorials/spring-boot-oauth2/ - The tutorial from which this project was born from.
