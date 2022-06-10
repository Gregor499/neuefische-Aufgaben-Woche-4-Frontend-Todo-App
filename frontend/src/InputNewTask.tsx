import {useEffect, useState} from "react";
import {Task} from "./model";
import TaskOutput from "./TaskOutput";

export default function InputNewTask(){

    const [newTask, setNewTask] = useState<Task[]>([]);

    const [error, setError] = useState("")

    useEffect(() => {
        fetch("http://localhost:8080/api/react", {
            method: "Post",
        })
            .catch(err => setError("error"));
    }, []);

    const addTask = () =>{
        return newTask.map(t => <TaskOutput
            task={{id: t.id, task: t.task, description: t.description, status: t.status}}/>) }

    return(
        <div className="tasks">
            <u>Neue Aufgabe:</u>
            {getNewTask()}
        </div>
    )
}