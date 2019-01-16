#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}

def setConfig(String name) {
  echo "Setting common configs" 
}
