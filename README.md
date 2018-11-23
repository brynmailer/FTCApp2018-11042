<h1>Welcome!</h1>

<p>This github repository conatins the complete source code for the app used to control team 11042's robot during the 2018 Rover Ruckus FTC season. This source code is provided to the Github community in the hopes of explaining the process of programming a competition robot to new teams or people who wish to take part in the awesome opportunity that is the First Technology Challenge.</p>
<p>The rest of this document will be split into two parts:</p>
<ul>
	<li><p><strong>Development and Refinement</strong></p></li>
	<li><p><strong>Documentation</strong></p></li>
</ul>
<p>The development and refinement section of this document will cover how our teams source code was developed and the processes that were undertaken to overcome the various issues that were encountered. The documentation section will talk about the code itself and will dissect it in an attempt to explain how our code works and how it is structured.</p>

<h1>Development and Refinement</h1>
<p>Prior to the 2018 Rover Ruckus FTC season, our team had already competed in one season of the ftc game, 2019. This meant that I had already amassed a years worth of scripts and java classes that I could reuse at will. In addition to this, I had also gained some extremely valuable knowledge from the previous years FTC competition.</p>
<p>After seeing all of the omni-directional robots at the last FTC nationals in sydney, I knew that this year I definitely wanted to have a drive system that could allow our robot the full range of horizontal translation while also being able to maintain a constant heading. This desire led me to spend a good chunk of the time before this year's competition programming and revising this system. In the end I succeeded and the final drive method can be seen in the Teamcode module.</p>
<p>The rest of the time spent before the competition was </p>
<p>More soon...</p>

<h1>Documentation</h1>
<p>In this section I will explain the exact functioning of the two opmodes that were used in the competition. This explanation will include details such as the flow of the program and definitions of what each piece of code actually achieves.</p>

<h2>GSRobot</h2>
<p>This is the class that defines and controls what components our robot is initialized with and the variables that are used to control them. The first part of this class is where all of the robot components are declared. This is a complete list of the components:</p>
<ul>
	<li><p>Type: DC Motor | Name: DriveMotor1</p></li>
	<li><p>Type: DC Motor | Name: DriveMotor2</p></li>
	<li><p>Type: DC Motor | Name: DriveMotor3</p></li>
	<li><p>Type: DC Motor | Name: DriveMotor4</p></li>
	<li><p>Type: DC Motor | Name: Lift</p></li>
	<li><p>Type: DC Motor | Name: PivotArm</p></li>
	<li><p>Type: DC Motor | Name: ExtendArm</p></li>
	<li><p>Type: DC Motor | Name: Sweeper</p></li>
	<li><p>Type: Servo | Name: SweeperFilter</p></li>
	<li><p>Type: Continuous Rotation Servo | Name: Dropper</p></li>
</ul>
<p>And these are the variables:</p>
<ul>
	<li><p>Type: Boolean | Name: SweeperIsOn | Value: false</p></li>
</ul>
<p>The next method is the init method. This method takes a single parameter of the type HardwareMap which it initializes to the name "ahwMap". The first action this method takes is to set the already defined components (e.g. DriveMotor1) to equal the appropriately configured devices in the configuration that is currently active on the robot controller app. This task makes use of the ahwMap parameter. The method then configures the direction of the motors so that when they are applied positive powers, they rotate in the correct direction. The last thing that this method does is set the powers of all the motors to zero. This is done in the hopes of preventing the motors from moving while initializing in the case of an unforseen error.</p>

<h2>Competition_OpModeAutonomous</h2>
<p>This opmode is used in the two minute driver controlled period of the competition and contains the main body of this robot's code. This opmode begins by creating a new GSRobot called "Robot". It then creates a new ElapsedTime object called runtime, this will be used to keep track of how far into the driver controlled period the game is. After the initial variable declarations, the init method is called. The first method call in this method.</p>

<h2>Competition_OpMode</h2>
<p></p>

<p>Coming soon...</p>
