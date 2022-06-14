import {Task} from "./model";
import './Style.css';
import React from "react";
import axios from "axios";

interface TaskProps {
    task: Task
    onTaskManipulation: () => void;
}

function deleteTask(taskId: string) {
    return axios.delete(`http://localhost:8080/api/react/${taskId}`)
}

function promoteTask(task: Task) {
    return axios.put('http://localhost:8080/api/react/next', task)
}

function demoteTask(task: Task) {
    return axios.put('http://localhost:8080/api/react/prev', task)
}

export default function TaskOutput(props: TaskProps) {

    const deleteCard = () => {
        deleteTask(props.task.id!)
            .then(props.onTaskManipulation)
    }

    const next = () => {
        promoteTask(props.task)
            .then(props.onTaskManipulation)
    }

    const prev = () => {
        demoteTask(props.task)
            .then(props.onTaskManipulation)
    }
        return (
        <div className="tasks">
            <br/>
            <div className="task-information">
                <div>
                    <span className="label">Id:</span> {props.task.id}
                </div>
                <div>
                    <span className="label">Task:</span> {props.task.task}
                </div>
                <div>
                    <span className="label">Description:</span> {props.task.description}
                </div>
                <div>
                    <span className="label">Status:</span> {props.task.status}
                </div>
                <div>
                    <button className="button2" onClick={prev}>previous</button>
                    <button className="button2" onClick={next}>next</button>
                    <button className="button2" onClick={deleteCard}>delete</button>
                    <button className="button2" /*onClick={edit}*/>edit</button>
                </div>
            </div>
        </div>
    )
}