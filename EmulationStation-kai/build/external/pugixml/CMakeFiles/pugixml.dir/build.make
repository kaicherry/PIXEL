# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.7

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/pi/es/PIXEL/EmulationStation-kai

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/pi/es/PIXEL/EmulationStation-kai/build

# Include any dependencies generated for this target.
include external/pugixml/CMakeFiles/pugixml.dir/depend.make

# Include the progress variables for this target.
include external/pugixml/CMakeFiles/pugixml.dir/progress.make

# Include the compile flags for this target's objects.
include external/pugixml/CMakeFiles/pugixml.dir/flags.make

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o: external/pugixml/CMakeFiles/pugixml.dir/flags.make
external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o: ../external/pugixml/src/pugixml.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pi/es/PIXEL/EmulationStation-kai/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o"
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && /usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/pugixml.dir/src/pugixml.cpp.o -c /home/pi/es/PIXEL/EmulationStation-kai/external/pugixml/src/pugixml.cpp

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/pugixml.dir/src/pugixml.cpp.i"
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pi/es/PIXEL/EmulationStation-kai/external/pugixml/src/pugixml.cpp > CMakeFiles/pugixml.dir/src/pugixml.cpp.i

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/pugixml.dir/src/pugixml.cpp.s"
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pi/es/PIXEL/EmulationStation-kai/external/pugixml/src/pugixml.cpp -o CMakeFiles/pugixml.dir/src/pugixml.cpp.s

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.requires:

.PHONY : external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.requires

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.provides: external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.requires
	$(MAKE) -f external/pugixml/CMakeFiles/pugixml.dir/build.make external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.provides.build
.PHONY : external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.provides

external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.provides.build: external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o


# Object files for target pugixml
pugixml_OBJECTS = \
"CMakeFiles/pugixml.dir/src/pugixml.cpp.o"

# External object files for target pugixml
pugixml_EXTERNAL_OBJECTS =

../libpugixml.a: external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o
../libpugixml.a: external/pugixml/CMakeFiles/pugixml.dir/build.make
../libpugixml.a: external/pugixml/CMakeFiles/pugixml.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/pi/es/PIXEL/EmulationStation-kai/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library ../../../libpugixml.a"
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && $(CMAKE_COMMAND) -P CMakeFiles/pugixml.dir/cmake_clean_target.cmake
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/pugixml.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
external/pugixml/CMakeFiles/pugixml.dir/build: ../libpugixml.a

.PHONY : external/pugixml/CMakeFiles/pugixml.dir/build

external/pugixml/CMakeFiles/pugixml.dir/requires: external/pugixml/CMakeFiles/pugixml.dir/src/pugixml.cpp.o.requires

.PHONY : external/pugixml/CMakeFiles/pugixml.dir/requires

external/pugixml/CMakeFiles/pugixml.dir/clean:
	cd /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml && $(CMAKE_COMMAND) -P CMakeFiles/pugixml.dir/cmake_clean.cmake
.PHONY : external/pugixml/CMakeFiles/pugixml.dir/clean

external/pugixml/CMakeFiles/pugixml.dir/depend:
	cd /home/pi/es/PIXEL/EmulationStation-kai/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/pi/es/PIXEL/EmulationStation-kai /home/pi/es/PIXEL/EmulationStation-kai/external/pugixml /home/pi/es/PIXEL/EmulationStation-kai/build /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml /home/pi/es/PIXEL/EmulationStation-kai/build/external/pugixml/CMakeFiles/pugixml.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : external/pugixml/CMakeFiles/pugixml.dir/depend

