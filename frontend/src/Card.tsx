import {useEffect, useState} from "react";
import TaskOutput from "./TaskOutput";
import {Task} from "./model";
import './Style.css';

export default function Card(){

    const [list, setList] = useState<Task[]>([]);

    const [error, setError] = useState("")

    useEffect(() => {
        fetch("http://localhost:8080/api/react", {
            method: "GET",
        })
            .then(response => response.json())
            .then(tasks => setList(tasks))
            .catch(err => setError("error"));
    }, []);

    const getList = () =>{
        return list.map(t => <TaskOutput
            task={{id: t.id, task: t.task, description: t.description, status: t.status}}/>) }

    return(
        <div className="tasks">
            <u>Aufgaben:</u>
            {getList()}
        </div>
    )
}