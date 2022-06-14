import {useEffect, useState} from "react";
import {Task} from "./model";
import TaskOutput from "./TaskOutput";

interface inputNewTaskProps{
    refreshFunction: Function;
}

export default function InputNewTask(props: inputNewTaskProps) {

    const [newTask, setNewTask] = useState<Task[]>([]);
    const [task, setTask] = useState("");
    const [description, setDescription] = useState("");


    const [error, setError] = useState("")

    function input(){
        fetch('http://localhost:8080/api/react', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({
                task: task,
                description: description,
                status: "OPEN"
            })
        })
            .then(()=>{
                props.refreshFunction()
            })
            .catch(err => {
                setError("hier is ein fehler error")
                console.log(err)
            });
    }

    return (
        <div className="tasks">
            <input className="text-field1" type="text" value={task} placeholder="Aufgabe" onChange={event => setTask(event.target.value)}/>
            <br/>
            <input className="text-field2" type="text" value={description} placeholder="Beschreibung" onChange={event => setDescription(event.target.value)}/>
            <br/>
            <button className="button1" onClick={input}>bestätigen</button>
            {error&&<div>{error}</div>}
            <br/>
        </div>
    )
}