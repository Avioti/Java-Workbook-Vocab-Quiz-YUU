# Avi's/Jalen's Workbook Vocab Quiz

## Vocabulary Quiz CLI App 
A simple Command Line Interface (CLI) application built in Java to test and improve vocabulary knowledge across various difficulty levels. This app features a randomized 10-question format designed to challenge and expand your word power.

## Features
### Quiz Structure
Difficulty Selection: Choose between Easy, Medium, and Hard quiz modes to match your skill level.

### 10-Question Format: Each quiz consists of a manageable set of 10 questions.

### Randomization
Shuffled Questions: Questions are randomly selected and shuffled from a large pool specific to the chosen difficulty.

Shuffled Options: The answer options (1-4) for each question are randomized every time, ensuring you cannot memorize option positions.

### Interaction & Scoring
One at a Time Display: Questions are presented individually, keeping the focus clear.

Simple Input: You enter the number corresponding to your chosen answer.

### Instant Feedback: Receive immediate feedback (Correct! or Incorrect.) after each answer.

### Final Score: A score summary is displayed at the end of the 10-question quiz.

## Screenshots

<img width="357" height="186" alt="image" src="https://github.com/user-attachments/assets/fb063938-ca1c-41ee-9197-8101be7a6aaf" />


Difficulty Selection

<img width="446" height="211" alt="image" src="https://github.com/user-attachments/assets/a5557159-f76f-4ba3-88bf-74fc9ef180ef" />


Question Display

<img width="885" height="191" alt="image" src="https://github.com/user-attachments/assets/6317d05b-1972-4751-b5a9-bb7b2d823c20" />


Answer Feedback

<img width="649" height="72" alt="image" src="https://github.com/user-attachments/assets/f647a94a-ac62-4a92-8eb6-ee807d88f5e4" />


Final Score Screen

<img width="315" height="99" alt="image" src="https://github.com/user-attachments/assets/326b6872-d834-4410-96ec-63d492df2b19" />


## How It Works

Difficulty Select - Choose your desired challenge level (Easy, Medium, or Hard) from the main menu.

Data Load - The application loads the vocabulary data for the selected difficulty from a CSV file.

Quiz Loop - The app selects 10 random questions, loops through them, presents the question and its shuffled options, and awaits your numbered input.

Answer Check - Your chosen option text is compared against the correct answer text stored in the data structure.

Quiz End - After the 10th question, the final score is calculated and displayed, and you are returned to the selection menu to try again or exit.

## Data Storage
All quiz data is loaded from CSV files based on the chosen difficulty (e.g., easy.csv). These files must reside in the src/main/resources/ directory.

The expected format for each row is:

question|answer1|answer2|answer3|answer4|correctAnswer
