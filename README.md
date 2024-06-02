# README

## [DEMO](https://khiibaedu-my.sharepoint.com/:v:/g/personal/a_iqbal_24529_khi_iba_edu_pk/ESxMIv1JNapLrD6QcwFeGqMBlkUol5a5hK3LyvT306cWwg?e=FEXFli&nav=eyJwbGF5YmFja09wdGlvbnMiOnt9LCJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbE1vZGUiOiJtaXMiLCJyZWZlcnJhbFZpZXciOiJwb3N0cm9sbC1jb3B5bGluayIsInJlZmVycmFsUGxheWJhY2tTZXNzaW9uSWQiOiJmZDcyNDFmZi1lYWUxLTRiNWItOGZmNi01MWRmMDc5YjM3MzgifX0%3D)
## Overview

This project aims to develop bar graph-making software that reads data from a file named “data.txt”. The data in the file consists of names and corresponding numerical values, which will be represented as bars in the graph. The software generates two types of bar graphs: one displaying data horizontally and another displaying data vertically. Additionally, the project includes functionality to create line graphs, where lines are drawn from one value to the next, creating a visual representation resembling mountains in a vertical orientation.

## Features
- **Scaling**: Automatic scaling of graphs according to the magnitude of values in "data.txt" as can be seen in the [demo](https://khiibaedu-my.sharepoint.com/:v:/g/personal/a_iqbal_24529_khi_iba_edu_pk/ESxMIv1JNapLrD6QcwFeGqMBlkUol5a5hK3LyvT306cWwg?e=FEXFli&nav=eyJwbGF5YmFja09wdGlvbnMiOnt9LCJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbE1vZGUiOiJtaXMiLCJyZWZlcnJhbFZpZXciOiJwb3N0cm9sbC1jb3B5bGluayIsInJlZmVycmFsUGxheWJhY2tTZXNzaW9uSWQiOiJmZDcyNDFmZi1lYWUxLTRiNWItOGZmNi01MWRmMDc5YjM3MzgifX0%3D)
- **Data Representation**: The software reads data from the "data.txt" file, where each entry contains a name and a numerical value.
- **Bar Graphs**: Bars are generated dynamically based on the number of data entries. The size of the bars adjusts according to the data, and each bar has a random color. The name of the data is displayed along with the bar.
- **Animated Bars**: Bars are drawn animatically, providing a visual representation of data.
- **Factory Pattern**: All bars and graph types are created using a factory pattern, enhancing modularity and extensibility.
- **Line Graphs**: The software includes functionality to create line graphs, where lines are drawn from one value to the next, creating a visual representation resembling mountains in a vertical orientation.
- **Interactive GUI**: The `JavaGraphs` file is run to launch a GUI where users can select the type of graph they want to create. After selecting, a graph of the chosen type is generated based on the values in the "data.txt" file.

## Implementation

- **Reading Data**: The software reads data from the "data.txt" file and processes it to create bars or lines in the graph.
- **Bar Size Calculation**: Mathematical calculations are performed to determine the size of the bars dynamically based on the data values.
- **Dynamic Drawing**: Bars or lines are drawn animatically within the graph area, ensuring that the visual representation remains confined to the specified dimensions.
- **Factory Pattern**: The factory pattern is implemented to create bars and graph types, promoting code reusability and flexibility.

## Usage

1. Ensure the "data.txt" file contains the required data entries in the specified format: Name followed by a numerical value, separated by a space.
2. Run the `JavaGraphs` file to launch the GUI.
3. Select the type of graph you want to create (horizontal bar graph, vertical bar graph, or line graph).
4. View the generated graph based on the selected type, where bars or lines represent the data entries visually.

## Notes

- Experiment with different datasets to visualize various data trends using bar or line graphs.
- The GUI provides an interactive way to select and generate different types of graphs based on the data provided in the "data.txt" file.