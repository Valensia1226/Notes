import datetime
import json

id = 0

def newNote():
    title = input("Введите заголовок: ")
    content = input("Введите содержание: ")
    now = datetime.datetime.now()
    date = "" + now.strftime("%d-%m-%Y %H:%M")
    global id
    id = id + 1
    note = "id: " + str(id) + ",\n" + "Title: " + title + ",\n" + "Content: " + content + ",\n" + "Date: " + date + "\n"
    return note

def add(_listOfNotes):
    note = newNote()
    _listOfNotes.append(note)
    return _listOfNotes

def showIdAndTitle(str):
    temp = str.split("Content")
    return temp[0]

def delete(_listOfNotes):
    for el in listOfNotes:
        print(showIdAndTitle(el))
    number = input("Введите id заметки, которую вы бы хотели удалить: \n")
    temp = "id: " + str(number)
    for el in _listOfNotes:
        if temp in el: _listOfNotes.remove(el)
    return _listOfNotes

def end(listOfNotes):
    text = input("Хотите сохранить заметки? Введите yes или no")
    match text.split():
        case ["yes"]:
            data = {}
            data['notes'] = []
            for el in listOfNotes:
                data["notes"].append({el})
            with open('data.txt', 'w') as outfile:
                json.dump(data, outfile)
            print("До свидания!")
        case["no"]:
            print("До свидания!")
        case _:  # Аналогично default в других языках
            print(f"Sorry, I couldn't understand {text!r}")
            end(listOfNotes)

def start(listOfNotes):
    text = input("Введите команду: \n"
                 "add - добавить заметку,\n"
                 "del - удалить заметку,\n"
                 "edit - редактировать заметку,\n"
                 "show - посмотреть список заметок\n"
                 "end - завершить работу\n")
    match text.split():
        case ["add"]:
            listOfNotes = add(listOfNotes)
            return True
        case ["del"]:
            listOfNotes = delete(listOfNotes)
            return True
        case ["show"]:
            for el in listOfNotes:
                print(el)
            return True
        case ["end"]:
            end(listOfNotes)
            return False
        case _:  # Аналогично default в других языках
            print(f"Sorry, I couldn't understand {text!r}")
            return True
        

work = True
listOfNotes = []
while (work):
    work = start(listOfNotes)